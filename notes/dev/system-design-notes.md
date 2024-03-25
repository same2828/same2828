# Table of Contents

- [Table of Contents](#table-of-contents)
- [OAuth2](#oauth2)

# OAuth2

## ByteByteGo

- [ByteByteGo](https://www.youtube.com/watch?v=ZV5yTm4pT8g)

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

## ByteMonk

- [ByteMonk](https://www.youtube.com/watch?v=ZDuRmhLSLOY)

- OAuth2 = Authorization Framework/Method that allows for services to access protected resources on behalf of users without sharing passwords
- 3rd party client makes request to the service -> User is asked to login via external service -> redirected to internal/external authorization server
- Authorization server generates "access tokens" which are keys that allow services to access a user's prtected resources on their behalf
- 3rd party client service then uses the access token to make request to the resource server
- Access token is normally used in conjunction with the authorisation header (added to each request made to the resource server)
- The authorisation header includes the access token, type of token, expiration time
  - `Authorization: Bearer <token>`
- JWT can be used to represent access tokens in OAuth2
  - JWTs are self contained, space effiicient, flexible and can be easily verified by the resource server
- Authoriszation Server is only responsible for issuing access tokens
- Identify provider is only responsible for authenticating users
- In some OAuth2 flows, the authorization server and identity provider roles may be combined

### OAuth Flows

#### Authorization Code Flow

- Used when the application needs to access protected resources on behalf of the user

- App sends the user to the authorization URL
- Authorization server authenticates the user and checks for consent
- If user grants access, a temporary authorization code is provided
- Authorization code is exchagned for an access token
- Obtain resources using the access token via API calls

- User first authenticates with the identity provider (IDP), the IDP redirects back to the application with an authorization code
- The application sends authroization code to the authoriation server which validates the code and returns an access token and a refresh token to the application
- The application can then use the access token to make requests to the resource server

#### Client Credentials Flow

- Used when the application does NOT access protected resources on behalf of the user
- Instead the application needs to access its OWN protected resources

- The application authenticates with the authorization server using its client id and client secret
- The authorization server returns an access token back to the application
- The application then uses the access token to make requests to its resource server

#### Resource Owner Password Flow

- Used when the application needs to access protected resources on behalf of the user BUT the user does NOT want to be redirected to the IDP
- Instead the application asks the user to enter the username and password directly into the application which then sends the credentials to the authorization server which validates the credentials and returns an access token and refresh token to the application
- The application can then use the access token to make a request to the resource server

#### Implicit Flow

- Simplified version of Authorization Code Flow
- The authorization server redirects the user back to the application with an access token in the URL
- The application can then use the access token to make requests to the resource server
