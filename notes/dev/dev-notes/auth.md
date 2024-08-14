# Table of Contents

- [Table of Contents](#table-of-contents)
- [Authentication](#authentication)
  - [Session Authentication](#session-authentication)
  - [Token Authentication](#token-authentication)
  - [Lightweight Directory Access Protocol LDAP](#lightweight-directory-access-protocol-ldap)
    - [Directory Information Tree (DIT)](#directory-information-tree-dit)
- [Authorisation](#authorisation)
  - [OAuth2](#oauth2)
    - [OAuth Flows](#oauth-flows)
      - [Authorisation Code Flow](#authorisation-code-flow)
      - [Client Credentials Flow](#client-credentials-flow)
      - [Resource Owner Password Flow](#resource-owner-password-flow)
      - [Implicit Flow](#implicit-flow)

# Authentication

> Authentication is the process of verifying the identity of a user

As HTTP is a stateless protocol, the client and server do not automatically keep track of subsequent requests.

- Resources
  - [Session-based Authentication - roadmap.sh](https://roadmap.sh/guides/session-based-authentication)
  - [JWT vs Cookies for token based authentication - StackOverflow](https://stackoverflow.com/questions/37582444/jwt-vs-cookies-for-token-based-authentication)

## Session Authentication

> Session authentication is associated with using cookies to manage sessions whereby the "cookie" holds identifying information about the user while the state is tracked on the server

The usual flow for Session based authentication is as follows

1. User submits a login request with their credentials
2. Server validates the credentials. If valid then creates a session on the database and a unique id, this unique id is sent back to the user in the form of a Cookie.
3. User saves the session id in the browser and sends this cookie back for each subsequent request to the server as a header.
4. If the session id is found in the database then it can retrieve information about the client

- Cookies should NOT be storing any important personal identifying information, only the corresponding session id in the server.
- When the user closes their browser the session cookies are automatically cleared.
  - The session information on the server will persist and be cleared until it expires or is explicitly cleared.
- Session IDs are relatively short lived and usually stored in a cache like redis to improve performance instead of being stored in the main DB.

## Token Authentication

The usual flow for token based authentication is as follows:

1. User submits login request with their credentials
2. Sever validates credentials. If valid then creates a signed token and sent back to the user.
3. User saves the token in the browser and can attach it for any future requests
4. Server can decrypt the token with its secret key to check its validity. If valid then it will authorize the request.

The difference between Session Authentication vs Token Authentication is that the server does NOT need to save anything about the user. State is stored on the token which is stored in the users browser.

[JSON Web Tokens (JWT)](https://jwt.io/) is a popular standard for creating signed data that contains a JSON payload. JWTs are often used tokens in authentication flows.

OpenID Connect (OIDC) and OAuth 2.0 are protocols commonly used in modern authentication and authorization systems.

- OAuth 2.0 is an authorization framework that allows third-party services to access resources on behalf of a resource owner (usually a user) without sharing the user's credentials.
- OIDC allows clients to verify the identity of the end user based on the authentication performed by an authorization server, as well as to obtain basic profile information about the user.

- Resources
  - [ID token vs Access Token - Auth0](https://auth0.com/blog/id-token-access-token-what-is-the-difference/)
  - [What are Refresh tokens - Auth0](https://auth0.com/blog/refresh-tokens-what-are-they-and-when-to-use-them/)
  - [An Illustrated Guide to OAuth and OIDC](https://youtu.be/t18YB3xDfXI)

## Lightweight Directory Access Protocol LDAP

Lightweight Directory Access Protocol (LDAP) is a vendor-neutral protocol used for accessing and maintaining distributed directory information services. A directory service is like a database that stores information about network resources, such as users, computers, printers, and other devices.

LDAP is commonly used to provide authentication and authorization services for networked resources. For example, when you log in to a computer that's part of a domain, the computer might use LDAP to check your username and password against the directory service to determine whether you're authorized to access the network.

LDAP is a client-server protocol, which means that there's a client application that sends requests to a server application to access the directory information. The client and server communicate using TCP/IP, and LDAP requests and responses are usually transmitted over port 389 or 636 (if using SSL).

LDAP directories are organized into a hierarchical tree structure, called [[notes/Directory Information Tree (DIT)]], where each node in the tree represents an object, such as a user or a group. Each object is identified by a unique name called a distinguished name (DN), which consists of a series of attributes separated by commas. For example, the DN for a user might be "cn=John Doe, ou=Users, dc=example, dc=com".

LDAP uses a query language called LDAP Query Language (LDAPQL) to search and retrieve information from the directory. LDAP queries are similar to SQL queries, but they use a different syntax and support different search filters and operations.

- Resources
  - https://www.onelogin.com/learn/what-is-ldap

### Directory Information Tree (DIT)

LDAP directories are organized in a hierarchical tree structure, similar to the directory structure of a file system. This structure is also known as the Directory Information Tree (DIT). At the top of the tree is the root node, and below that are branches and sub-branches that represent the various objects and attributes in the directory.

Each object in the directory is represented by an entry in the tree, and each entry is identified by a unique name called a distinguished name (DN). The distinguished name of an entry is composed of the names of all the nodes (or branches) that lead to that entry, starting from the root of the tree.

For example, suppose we have an LDAP directory that contains information about employees in a company. The top-level node in the tree might be the organization's name, followed by sub-nodes for departments, teams, and individual employees. The distinguished name for an employee named "John Smith" in the "Sales" department might look something like this:

cn=John Smith,ou=Sales,ou=Departments,o=MyCompany,c=US

Here, "cn" stands for "common name", "ou" stands for "organizational unit", "o" stands for "organization", and "c" stands for "country". These are all examples of attributes that can be used to identify and categorize entries in the directory. LDAP DNs also ascend the tree from left to right, Here the John Smith is directly under Sales and Sales is part of Departments and so on.

It is common practice to refer to the leftmost component of an entry's DN as the RDN for that entry. In the above example, the RDN would be cn=John Smith.

The distinguished name of an entry is important because it provides a unique identifier that can be used to retrieve or modify the entry. When a client application wants to access an entry in the directory, it sends a request to the LDAP server that includes the distinguished name of the entry it wants to access.

- Resources
  - https://ldap.com/ldap-dns-and-rdns/

# Authorisation

> Authorization = The process of giving an authenticated user permission to access resources (based on policies/rules)

## OAuth2

**ByteByteGo**

> OAuth 2.0 is an authorisation framework that allows different applications to securely interact with each other on behalf of users without sharing sensitive credentials

- Traditionally verification/authentication was done via username + password
- Now we give users "resource" keys to access specific information
  - We control who gets access to our data without having to share passwords
  - These "resource" keys can be revoked at anytime
- Case Study Example of OAuth2 Flow

  - Consider a photo storage application "SnapStore" that we use to upload our photos to
  - We want to print out our photos using an external 3rd party service called "PrintMagic"
  - Instead of uploading each photo to PrintMagic we can "grant" PrintMagic permission to access our photos on "SnapStore"
  - Using OAuth2 "PrintMagic" can access our SnapStore photos on our behalf without ever knowing our SnapStore login credentials
  - Deeper Analysis
    - We are the "resource owner" (because we own our photos on SnapStore)
    - SnapStore is the "resource server" that stores our photos
    - PrintMagic is the "client" that wants to access our photos
    - The authorisation service could be a part of SnapStore or an external identity provider and is responsible for handling the OAuth2 process

- Note: `clientsecret` is a private key shared only between PrintMagic and the Authorisation Server
- Note: Access tokens can be configured to expire after a certain time or be revoked by the user at anytime (providing an extra layer of security)
- OAuth2 also supports refresh tokens which can be used to obtain a new access token when the old one expires without requiring user intervention

- [ByteByteGo](https://www.youtube.com/watch?v=ZV5yTm4pT8g)

![](images/oauth2.jpg)
![](https://substackcdn.com/image/fetch/f_auto,q_auto:good,fl_progressive:steep/https%3A%2F%2Fsubstack-post-media.s3.amazonaws.com%2Fpublic%2Fimages%2Fbb375f63-bf06-4956-b3a3-914fd6aa2d91_1280x1664.jpeg)

**ByteMonk**

- OAuth2 = Authorisation Framework/Method that allows for services to access protected resources on behalf of users without sharing passwords
- 3rd party client makes request to the service -> User is asked to login via external service -> redirected to internal/external authorisation server
- Authorisation server generates "access tokens" which are keys that allow services to access a user's protected resources on their behalf
- 3rd party client service then uses the access token to make request to the resource server
- Access token is normally used in conjunction with the authorisation header (added to each request made to the resource server)
- The authorisation header includes the access token, type of token, expiration time
  - `Authorisation: Bearer <token>`
- JWT can be used to represent access tokens in OAuth2
  - JWTs are self contained, space efficient, flexible and can be easily verified by the resource server
- Authorisation Server is only responsible for issuing access tokens
- Identify provider is only responsible for authenticating users
- In some OAuth2 flows, the authorisation server and identity provider roles may be combined

- [ByteMonk](https://www.youtube.com/watch?v=ZDuRmhLSLOY)

### OAuth Flows

#### Authorisation Code Flow

- Used when the application needs to access protected resources on behalf of the user

- App sends the user to the authorisation URL
- Authorisation server authenticates the user and checks for consent
- If user grants access, a temporary authorisation code is provided
- Authorisation code is exchanged for an access token
- Obtain resources using the access token via API calls

- User first authenticates with the identity provider (IDP), the IDP redirects back to the application with an authorisation code
- The application sends authorisation code to the authorisation server which validates the code and returns an access token and a refresh token to the application
- The application can then use the access token to make requests to the resource server

#### Client Credentials Flow

- Used when the application does NOT access protected resources on behalf of the user
- Instead the application needs to access its OWN protected resources

- The application authenticates with the authorisation server using its client id and client secret
- The authorisation server returns an access token back to the application
- The application then uses the access token to make requests to its resource server

#### Resource Owner Password Flow

- Used when the application needs to access protected resources on behalf of the user BUT the user does NOT want to be redirected to the IDP
- Instead the application asks the user to enter the username and password directly into the application which then sends the credentials to the authorisation server which validates the credentials and returns an access token and refresh token to the application
- The application can then use the access token to make a request to the resource server

#### Implicit Flow

- Simplified version of Authorisation Code Flow
- The authorisation server redirects the user back to the application with an access token in the URL
- The application can then use the access token to make requests to the resource server
