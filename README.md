## Treinamento de Automação de Testes Web
Este é um repositório de automação com o objetivo de fins para estudo e prática, que contém alguns testes via web/browser de um site chamado: https://automationexercise.com/.
Abaixo você poderá observar alguns tópicos, onde irá ter a descrição sobre as decisões que foram tomadas, e o modo como  o projeto foi estruturado.
### Tecnologias/frameworks utilizados
- Java - https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html
- Maven - https://maven.apache.org/
- Junit - https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.10.2
- Selenium - https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.18.1

### Notas Gerais

Para o desenvolvimento do projeto, está sendo utilizado alguns padrões de desenvolvimento de códigos (Design Pattern):
- como o Page Object, onde seu objetivo é abstrair uma página que será automatizada para a sua classe, trazendo alguns benefícios como maior independência dos testes, facilidade na manutenção e um código mais limpo.

- E também, utilizand o Fluent Page onde seu objetivo é encadear os métodos da página que será automatizada, tornando o código mais legível e simples de ser usado.