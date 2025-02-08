# Table of Contents

- [Table of Contents](#table-of-contents)
- [REST Api Clients](#rest-api-clients)
- [Curl CLI](#curl-cli)
  - [`multipart/form-data` Body](#multipartform-data-body)

# REST Api Clients

- https://hoppscotch.io/
- https://github.com/usebruno/bruno/releases

# Curl CLI

## `multipart/form-data` Body

```
curl --request POST \
  --url http://localhost:8080/api/v1/my-path
  --header 'Authorization: Basic Og==' \
  --header 'Content-Type: multipart/form-data' \
  --header 'content-type: multipart/form-data' \
  --form content=@/Users/<user>/Downloads/file.pdf
  --form 'metadata={
    "users": [
      {
        "userId": "usr1234"
        "userProfile": {
          "firstName": "Jane",
          "lastName": "Smith",
          "email": "jane.smith@example.com",
          "role": "admin"
        },
        "documents": [
          {
            "fileName": "file.pdf",
            "fileSize": 2048576,
            "createdDate": "2024-03-19T15:30:22Z"
            "lastModifiedDate": "2024-03-19T15:30:22Z"
            "mimeType": "application/pdf",
          }
        ]
      },
    ],
  };type=application/json' \
  --form 'traceparent=uuid1234'
```
