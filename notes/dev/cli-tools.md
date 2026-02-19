# Table of Contents

- [Table of Contents](#table-of-contents)
- [Exiftool](#exiftool)
- [JQ + PubSub](#jq--pubsub)

# Exiftool

https://exiftool.org/

```
brew install exiftool

exiftool -all= -overwrite_original INSERT_IMAGE_NAME_HERE.jpg
```

# JQ + PubSub

[gcloud pubsub topics publish](https://docs.cloud.google.com/sdk/gcloud/reference/pubsub/topics/publish)

- In jq, string interpolation is performed using `\(expression)` inside string literals `""`
- The `\(` syntax tells jq to evaluate the expression inside the parentheses (like .key or .value) and insert the result into the string being built.
- In the example below: `map("\(.key)=\(.value)")`
  - Starts a string literal: `"`
  - Encounters `\(.key)`, evaluates and inserts the value of the `.key` variable/property of the current object
  - Adds a literal `=` sign
  - Encounters `\(.value)`, evaluates and inserts the value of the `.value` variable/property of the current object
  - Ends the string literal: `"`
- Without the backslash and parentheses (e.g. `map("(.key)=(.value)"`), jq would treat it as a literal string containing the text `"(.key)=(.value)"` rather than the actual data

```sh
gcloud pubsub topics publish insert-topic-name-here \
--attribute="$(jq -r '.attributes | to_entries | map("\(.key)=\(.value)") | join(",")' insert-json-file-here.json)" \
--message="$(jq -c '.data' insert-json-file-here.json)"
```

```
# Example output
message-timestamp=2024-06-01T14:00:22Z,parent-span-id=fedcba0987654321,span-id=abcdef1234567890,trace-id=1234567890abcdef
[{"dealId":123456,"title":"50% Off All Electronics @ TechSuperStore","description":"Half price on all laptops, gaming consoles, and accessories. Free shipping for orders over $50.","price":0,"originalPrice":0,"currency":"AUD","retailer":"TechSuperStore","link":"https://www.techsuperstore.com.au/sale","postedBy":"BargainHunter99","postedDate":"2024-06-01T13:45:00Z","expiryDate":"2024-06-08T23:59:59Z","categories":["Computing","Gaming"],"voteCount":245,"commentCount":82,"isExpired":false,"isFeatured":true,"couponCode":"TECH50"},{"dealId":123457,"title":"Woolworths ½ Price: Connoisseur 1L $6.50, Omo Laundry Powder $14","description":"Weekly half price specials starting Wednesday. Stock up on ice cream and laundry needs.","price":6.5,"originalPrice":13.0,"currency":"AUD","retailer":"Woolworths","link":"https://www.woolworths.com.au/specials","postedBy":"GrocerySaver","postedDate":"2024-06-02T09:00:00Z","expiryDate":"2024-06-08T23:59:59Z","categories":["Groceries"],"voteCount":512,"commentCount":104,"isExpired":false,"isFeatured":true,"couponCode":null}]
```

```json
{
  "attributes": {
    "message-timestamp": "2024-06-01T14:00:22Z",
    "parent-span-id": "fedcba0987654321",
    "span-id": "abcdef1234567890",
    "trace-id": "1234567890abcdef"
  },
  "data": [
    {
      "dealId": 123456,
      "title": "50% Off All Electronics @ TechSuperStore",
      "description": "Half price on all laptops, gaming consoles, and accessories. Free shipping for orders over $50.",
      "price": 0,
      "originalPrice": 0,
      "currency": "AUD",
      "retailer": "TechSuperStore",
      "link": "https://www.techsuperstore.com.au/sale",
      "postedBy": "BargainHunter99",
      "postedDate": "2024-06-01T13:45:00Z",
      "expiryDate": "2024-06-08T23:59:59Z",
      "categories": ["Computing", "Gaming"],
      "voteCount": 245,
      "commentCount": 82,
      "isExpired": false,
      "isFeatured": true,
      "couponCode": "TECH50"
    },
    {
      "dealId": 123457,
      "title": "Woolworths ½ Price: Connoisseur 1L $6.50, Omo Laundry Powder $14",
      "description": "Weekly half price specials starting Wednesday. Stock up on ice cream and laundry needs.",
      "price": 6.5,
      "originalPrice": 13.0,
      "currency": "AUD",
      "retailer": "Woolworths",
      "link": "https://www.woolworths.com.au/specials",
      "postedBy": "GrocerySaver",
      "postedDate": "2024-06-02T09:00:00Z",
      "expiryDate": "2024-06-08T23:59:59Z",
      "categories": ["Groceries"],
      "voteCount": 512,
      "commentCount": 104,
      "isExpired": false,
      "isFeatured": true,
      "couponCode": null
    }
  ]
}
```
