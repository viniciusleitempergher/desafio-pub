<h1 align="center">Projeto Desafio PubFuture</h1>

<h2 align="center">Instruções sobre como rodar:</h2>

<p align="justify">Para rodar o projeto é necessário possuir apenas o Docker instalado no computador. Caso esteja no linux, também é necessário instalar o docker-compose.</p>
<p align="justify">Para executar o projeto, primeiro abra o terminal na pasta raíz do projeto.</p>
<p align="justify">Em seguida, construa a imagem do banco utilizando o comando: </p>

 * docker build -t pubdatabase ./postgres

<p align="justify">Após isso, importe os projetos no Eclipse ou em alguma outra IDE de preferência, clique com o direito em um projeto, vá em "run as" e em seguida "maven build". No campo Goals, escreva: "spring-boot:build-image -DskipTests" sem as aspas. Faça isso em todos os projetos</p>

 <p align="justify">Por fim, utilize o comando</p>

 * docker-compose up

 <strong>OBSERVAÇÃO: </strong> Para rodar o projeto não pode existir nenhum acento ou espaço no diretório do projeto!