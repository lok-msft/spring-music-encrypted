<div id="top"></div>

<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/lok-msft/spring-music-always-encrypted">
    <img src="images/springboot-logo-only.png" alt="Spring" width="80" height="80">
  </a>

  <h3 align="center">Spring Data JPA vs Spring Data JDBC, for Always-Encrypted column in Azure SQL</h3>

  <p align="center">
    Spring Boot + Spring Data (JPA vs JDBC) sample code for query always-encrypted column in Azure SQL
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

To show what's the expected behaviour when leveraging Spring Boot + Spring Data (Repository):
* [Spring Data JPA](https://spring.io/projects/spring-data-jpa) vs
* [Spring Data JDBC](https://spring.io/projects/spring-data-jdbc)
to query Azure SQL DB with always-encrypted columns 

Here's highlight:
* CRUD Repository with always-encrypted columns - no @Query
* Custom query with named paramter - making use of @Query
* Show potential exception we may come across when using @Query

Please read this doc about SQL Server JDBC driver [unsupported-data-type-conversion-errors](https://docs.microsoft.com/en-us/sql/connect/jdbc/using-always-encrypted-with-the-jdbc-driver?view=sql-server-ver16#unsupported-data-type-conversion-errors)

See expected response/exception in [REST-client-test.http](REST-client-test.http)

** Focus on giving you some ideas about various Spring Data (Repository) behaviour when handling always-encrypted columns

** DO NOT take this codebase as a production-ready release, you may need extra consideration about performance optimization and security measure fit your project and organization specific requirement

For how to run query at SSMS for table with encrypted column, please refer to this [blog:  parameterization-for-always-encrypted-using-ssms](https://techcommunity.microsoft.com/t5/azure-sql-blog/parameterization-for-always-encrypted-using-ssms-to-insert-into/ba-p/386124)

<p align="right">(<a href="#top">back to top</a>)</p>



### Built With

Key dependencies used to bootstrap the project: 

* spring-boot-starter-data-jpa
* spring-boot-starter-data-jdbc
* azure-identity _runtime only_
* azure-security-keyvault-keys _runtime only_
* mssql-jdbc _runtime only_


<p align="right">(<a href="#top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

Assuming you have some Azure SQL DB up and running

* create relevant table and configure always-encrypted columns
  ```sql
  CREATE SCHEMA music;
  CREATE TABLE music.artist(
        [ArtistId] [int] NOT NULL,
        [PayToken] [int] NULL, -- always-encrypted
        [Email] [nvarchar](50) NULL, -- always-encrypted
        [Phone] [char](15) NULL, -- always-encrypted
        [FirstName] [nvarchar](50) NULL,
        [LastName] [nvarchar](50) NULL,
        [City] [nvarchar](50) NULL,
        [BirthDate] [date] NOT NULL,
        PRIMARY KEY CLUSTERED ([ArtistId] ASC) ON [PRIMARY] );
  ```

* git clone this repo or just copy source code to a new project created by template from [start.spring.io](https://start.spring.io/)

* put down the valid database connection string in application.properties
  ```sh
  spring.datasource.url=jdbc:sqlserver://server-url:port;database=db-name;columnEncryptionSetting=Enabled;keyStoreAuthentication=KeyVaultClientSecret;keyStorePrincipalId=app-id;keyStoreSecret=app-secret;
  ```

* maven build
  ```sh
  mvnw.cmd clean package -Dmaven.test.skip=true
  ```

* run localhost:8080
  ```sh
  mvnw.cmd spring-boot:run
  ```

### Prerequisites

tools and runtime needed before you can build and run the sample:
* OpenJDK 11 - [download](https://docs.microsoft.com/en-us/java/openjdk/download#openjdk-11)
* some IDE for Java project
* SQL Server Management Studio (SSMS) - [download](https://docs.microsoft.com/en-us/sql/ssms/download-sql-server-management-studio-ssms?view=sql-server-ver15) - to create table and configure always-encrypted columns 
* An Azure account and subscription. If you don't have one, sign up for a [free trial](https://azure.microsoft.com/pricing/free-trial/).
* A database in Azure SQL Database or Azure SQL Managed Instance
* permission for Azure Key Vault - create relevant keys for always-encrypted
* permission for Azure Active Directory (Azure AD) - create service principal for the app to access key vault
* Azure App Service / AKS - potentially running this app on Azure instead of desktop localhost

### Installation

_Configure Always Encrypted by using Azure Key Vault_
[Read official doc](https://docs.microsoft.com/en-us/azure/azure-sql/database/always-encrypted-azure-key-vault-configure?view=azuresql&tabs=azure-cli#create-a-key-vault-to-store-your-keys)

Quick highlight:
1. TODO
2. TODO
   ```sh
   todo
   ```

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- USAGE EXAMPLES -->
## Usage

_Use Case - TODO_

<!-- ROADMAP -->
## Roadmap

- [ ] TODO 1
- [ ] TODO 2

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- CONTRIBUTING -->
## Contributing

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- LICENSE -->
## License

Distributed under the Do-Whatever-You-Want License.

**Permissions**

- &#x2713;  Commercial use
- &#x2713;  Modification
- &#x2713;  Distribution
- &#x2713;  Private use

**Limitations**

- &#x274c;  No Liability
- &#x274c;  No Warranty

**Conditions**

- &#x25cb;  License and copyright notices

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- CONTACT -->
## Contact


<p align="right">(<a href="#top">back to top</a>)</p>


<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

This project is made possible by the community surrounding it and especially the wonderful people and projects listed below

* [Spring team](https://spring.io/projects)
* [Microsoft SQL Server JDBC Driver](https://github.com/microsoft/mssql-jdbc)
* [Spring Initializr](https://start.spring.io/)
* [Microsoft Build of OpenJDK](https://www.microsoft.com/openjdk)
* [Visual Sutdio Code](https://code.visualstudio.com/)

<p align="right">(<a href="#top">back to top</a>)</p>

