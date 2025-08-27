# Test Java Back-End

### Dependências usasdas 
**Spring Boot:**  
•Validation - Valida automaticamente os dados em um Controller antes que de sejam iseridas no banco de dados.  
•WEB - É um pacote de ferramentas para projetos que facilitam o projeot WEB.  
•JPA - Intermediador entre sua aplicação e seu banco de dados.  
•Maven-Plugin - Traz uma biblioteca que facilita a construção de aplicações Spring Boot.   
  
**Banco de dados:** Postgresql    
  
**Programas:** InteliJ // PgAdmin4 // Postman  

### Arquitetura do Projeto

**/test_java/main/src/java/com.wswork.test_java/**  
                                             •/Configs -> Cors e Tratamento de Bad Request  
                                             •/Controladores -> CRUD - CREATE, READ, UPDATE, DELETE  
                                             •/DTOS -> Realiza a comunicação entre aplicação e Usuários  
                                             •/Modelos -> Esta a regra de negócio, e Estruturação das tabelas.  
                                             •/Repositórios -> Ligação entre aplicação com o Banco de Dados.  

## Funcionalidade
### CRUD MARCAS  
<img width="770" height="798" alt="image" src="https://github.com/user-attachments/assets/87923920-50d7-4904-8e0b-b4a652324c28" />  <br/>
### CRUD MODELOS ManyToOne MARCAS   
<img width="814" height="846" alt="image" src="https://github.com/user-attachments/assets/6b1eb3ce-fe50-47d5-94c1-4b65c8a31460" />  <br/>
### CRUD CARROS ManyToOne MODELOS, com a formatação exigida para o consumo no Front-End
<img width="829" height="871" alt="image" src="https://github.com/user-attachments/assets/6e48e1c7-930f-4948-b427-559dbad52f34" /> <br/>

