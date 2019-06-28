# iesp-aula-15-06-19-ORM

## Requisitos:
1. Cadastro 
	- Paceiente
	- Medico
	- Consulta
2. Agendamento
3. Consulta por periodo
4. Agendamento por periodo
5. Consultar pacientes
6. Cancelar consultas
7. Cancelar agendamentos
8. Reagendamento de consulta

## Regras de negócio:
1. Não pode existir dois agendamentos para o mesmo horário (dia/hora)
2. Não pode efetuar agendamento com data retroativa
3. Posso cancelar agendamento
4. No cadastro do médico é necessário informar os dias de atendimento (Horários disponíveis para agendamento de consulta)
5. Médico pode cancelar uma consulta, no ato cancealamento uma possível atendente poderá reagendar






# Saida:
#### 1 - Cadastro de Pasciente <br />
jun 28, 2019 8:18:11 PM org.hibernate.hql.internal.QueryTranslatorFactoryInitiator initiateService
INFO: HHH000397: Using ASTQueryTranslatorFactory
<br />Optional[Pessoa{id=1, nome='Sergio', cpf='159753123419', dataNascimento=Fri Feb 14 00:00:00 GMT-03:00 1992}]

#### 1 - Cadastro de Medico
Optional[Medico{NOME='Dr House'CPF='159753123457'NASCIMENTO='Thu Feb 14 00:00:00 GMT-03:00 1952'CRM='1234568'}]

#### 2 - Cadastro Agendamento/Consulta <br />
2 - Agendamento com data retroativa <br />
<span style="color:red">Data de Agendamento Invalida: 18/06/2019 10:00:00</span>

2 - Agendamento no mesmo dia mas em hora retroativa <br />
<span style="color:red">Data de Agendamento Invalida: 27/06/2019 10:00:00</span>

2 - Agendamento 1 - Mesmo dia para paciente e medico diferentes

2 - Agendamento 2 - Mesmo dia para paciente e medico diferentes <br />
Agendamento{id=1, dataDaConsulta=Mon Jul 22 10:00:00 GMT-03:00 2019, diaDoAgentamento=Fri Jun 28 20:18:12 GMT-03:00 2019, paciente=Pessoa{id=5, nome='Arthugio', cpf='159753123450', dataNascimento=Fri Jun 28 20:18:12 GMT-03:00 2019}, status=NORMAL}

2 - Agendamento 3 - Mesmo Horario que Agendamento 1<br />
<span style="color:red">Data informada ja possui Agendamento: 22/07/2019 10:00:00<br /></span>


2 - Agendamento 4 - Data e Hora valida <br />
Agendamento{id=3, dataDaConsulta=Thu Jul 25 10:30:00 GMT-03:00 2019, diaDoAgentamento=Fri Jun 28 20:18:12 GMT-03:00 2019, paciente=Pessoa{id=5, nome='Arthugio', cpf='159753123450', dataNascimento=Fri Jun 28 20:18:12 GMT-03:00 2019}, status=NORMAL}

2 - Agendamento 5 - Data e Hora valida<br />
Agendamento{id=4, dataDaConsulta=Fri Jul 26 11:00:00 GMT-03:00 2019, diaDoAgentamento=Fri Jun 28 20:18:12 GMT-03:00 2019, paciente=Pessoa{id=5, nome='Arthugio', cpf='159753123450', dataNascimento=Fri Jun 28 20:18:12 GMT-03:00 2019}, status=NORMAL}

2 - Agendamento 6 - Dia do Medico Invalido<br />
<span style="color:red">Data de Agendamento Invalida, Medico nao disponivel para o dia: 20/07/2019 12:00:00</span>

#### 3 - Consultar Consultas por Perí­odo<br />
Consulta{id=1, medico=Medico{NOME='Dr House'CPF='159753123457'NASCIMENTO='1952-02-14'CRM='1234568'}, agendamento=Agendamento{id=1, dataDaConsulta=2019-07-22 10:00:00.0, diaDoAgentamento=2019-06-28 20:18:12.0, paciente=Pessoa{id=5, nome='Arthugio', cpf='159753123450', dataNascimento=2019-06-28}, status=NORMAL}, dataDaConsulta=2019-07-22 10:00:00.0, status=NORMAL}

Consulta{id=2, medico=Medico{NOME='Arthur'CPF='159753123520'NASCIMENTO='2019-06-28'CRM='1234567'}, agendamento=Agendamento{id=2, dataDaConsulta=2019-07-22 10:00:00.0, diaDoAgentamento=2019-06-28 20:18:12.0, paciente=Pessoa{id=4, nome='Arthur', cpf='159753123430', dataNascimento=2019-06-28}, status=NORMAL}, dataDaConsulta=2019-07-22 10:00:00.0, status=NORMAL}

Consulta{id=3, medico=Medico{NOME='Dr House'CPF='159753123457'NASCIMENTO='1952-02-14'CRM='1234568'}, agendamento=Agendamento{id=3, dataDaConsulta=2019-07-25 10:30:00.0, diaDoAgentamento=2019-06-28 20:18:12.0, paciente=Pessoa{id=5, nome='Arthugio', cpf='159753123450', dataNascimento=2019-06-28}, status=NORMAL}, dataDaConsulta=2019-07-25 10:30:00.0, status=NORMAL}

#### 4 - Consultar Agendamento por Perí­odo<br />
Agendamento{id=1, dataDaConsulta=Mon Jul 22 10:00:00 GMT-03:00 2019, diaDoAgentamento=Fri Jun 28 20:18:12 GMT-03:00 2019, paciente=Pessoa{id=5, nome='Arthugio', cpf='159753123450', dataNascimento=Fri Jun 28 20:18:12 GMT-03:00 2019}, status=NORMAL}

Agendamento{id=2, dataDaConsulta=Mon Jul 22 10:00:00 GMT-03:00 2019, diaDoAgentamento=Fri Jun 28 20:18:12 GMT-03:00 2019, paciente=Pessoa{id=4, nome='Arthur', cpf='159753123430', dataNascimento=Fri Jun 28 20:18:11 GMT-03:00 2019}, status=NORMAL}

Agendamento{id=3, dataDaConsulta=Thu Jul 25 10:30:00 GMT-03:00 2019, diaDoAgentamento=Fri Jun 28 20:18:12 GMT-03:00 2019, paciente=Pessoa{id=5, nome='Arthugio', cpf='159753123450', dataNascimento=Fri Jun 28 20:18:12 GMT-03:00 2019}, status=NORMAL}

#### 5 - Consultar Paciente<br />
Pessoa{id=1, nome='Sergio', cpf='159753123419', dataNascimento=Fri Feb 14 00:00:00 GMT-03:00 1992}

#### 6 - Cancelar consultas<br />
Consulta{id=4, medico=Medico{NOME='Dr House'CPF='159753123457'NASCIMENTO='1952-02-14'CRM='1234568'}, agendamento=Agendamento{id=4, dataDaConsulta=2019-07-26 11:00:00.0, diaDoAgentamento=2019-06-28 20:18:12.0, paciente=Pessoa{id=5, nome='Arthugio', cpf='159753123450', dataNascimento=2019-06-28}, status=NORMAL}, dataDaConsulta=2019-07-26 11:00:00.0, status=CANCELADA}

#### 7 - Cancelar um agendamento <br />
7 - Agendamento: 3 cancelado<br />
Agendamento{id=3, dataDaConsulta=Thu Jul 25 10:30:00 GMT-03:00 2019, diaDoAgentamento=Fri Jun 28 20:18:12 GMT-03:00 2019, paciente=Pessoa{id=5, nome='Arthugio', cpf='159753123450', dataNascimento=Fri Jun 28 20:18:12 GMT-03:00 2019}, status=CANCELADA}

7 - Agendamento: 4 cancelado <br />
Agendamento{id=4, dataDaConsulta=Fri Jul 26 11:00:00 GMT-03:00 2019, diaDoAgentamento=Fri Jun 28 20:18:12 GMT-03:00 2019, paciente=Pessoa{id=5, nome='Arthugio', cpf='159753123450', dataNascimento=Fri Jun 28 20:18:12 GMT-03:00 2019}, status=CANCELADA}

#### 8 - Reagendamento de consulta <br />
Agendamento{id=3, dataDaConsulta=Fri Jul 26 13:00:00 GMT-03:00 2019, diaDoAgentamento=Fri Jun 28 20:18:12 GMT-03:00 2019, paciente=Pessoa{id=5, nome='Arthugio', cpf='159753123450', dataNascimento=Fri Jun 28 20:18:12 GMT-03:00 2019}, status=REAGENDADA}
2 - Agendamento 7 - Agendando em uma hora cancelada

Agendamento{id=5, dataDaConsulta=Fri Jul 26 11:00:00 GMT-03:00 2019, diaDoAgentamento=Fri Jun 28 20:18:12 GMT-03:00 2019, paciente=Pessoa{id=5, nome='Arthugio', cpf='159753123450', dataNascimento=Fri Jun 28 20:18:12 GMT-03:00 2019}, status=NORMAL}

#### Medico Cancela Consulta<br />
Consulta{id=1, medico=Medico{NOME='Dr House'CPF='159753123457'NASCIMENTO='1952-02-14'CRM='1234568'}, agendamento=Agendamento{id=1, dataDaConsulta=2019-07-22 10:00:00.0, diaDoAgentamento=2019-06-28 20:18:12.0, paciente=Pessoa{id=5, nome='Arthugio', cpf='159753123450', dataNascimento=2019-06-28}, status=NORMAL}, dataDaConsulta=2019-07-22 10:00:00.0, status=CANCELADA}

#### Atendimento verifica os agendamentos que tiveram a consulta cancelada para tentar reagenda<br />
Agendamento{id=1, dataDaConsulta=Thu Jul 25 11:00:00 GMT-03:00 2019, diaDoAgentamento=Fri Jun 28 20:18:12 GMT-03:00 2019, paciente=Pessoa{id=5, nome='Arthugio', cpf='159753123450', dataNascimento=Fri Jun 28 20:18:12 GMT-03:00 2019}, status=REAGENDADA}

Process finished with exit code 0