<h1 align="center">Projeto Desafio PubFuture</h1>

<h2 align="center">Instruções sobre como rodar:</h2>

<p align="justify">Para rodar o projeto é necessário possuir apenas o Docker instalado no computador. Caso esteja no linux, também é necessário instalar o docker-compose.</p>
<p align="justify">Para executar o projeto, primeiro abra o terminal na pasta raíz do projeto.</p>
<p align="justify">Em seguida, construa as imagens dos serviços utilizando os seguintes comandos: </p>

 * docker build ./account-service
 * docker build ./api-gateway
 * docker build ./expending-balance-service
 * docker build ./incoming-balance-service
 * docker build ./naming-server
 * docker build --name pubdatabase ./postgres

 <p align="justify">Após ter construído todas as imagens, basta iniciar tudo com o comando:</p>

 * docker-compose up