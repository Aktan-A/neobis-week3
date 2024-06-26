# Order Endpoints

### GET `/api/v1/orders/{order_id}`

- Description: Get order details by id
- Headers:
```
  Authorization: Bearer token
```

- Response 200

```json
{
    "id": 1,
    "userId": 1,
    "status": "CREATED",
    "createdAt": "2024-05-23T16:59:30.363224"
}
```

### GET `/api/v1/orders`

- Description: Get all orders
- Headers:
```
  Authorization: Bearer token
```

- Response 200

```json
[
    {
        "id": 1,
        "userId": 1,
        "status": "CREATED",
        "createdAt": "2024-05-23T16:59:30.363224"
    }
]
```

### POST `/api/v1/orders`

- Description: Create an order
- Headers:
```
  Authorization: Bearer token
```

- Request Body:
```json
{
    "userId": 1
}
```

- Response 201

```json
{
    "id": 1,
    "userId": 1,
    "status": "CREATED",
    "createdAt": "2024-05-23T16:59:30.363224"
}
```

### PUT `/api/v1/orders/{order_id}`

- Description: Update an order by id
- Headers:
```
  Authorization: Bearer token
```

- Request Body:
```json
{
  "status": "SHIPPED"
}
```

- Response 200

```json
{
    "id": 1,
    "userId": 1,
    "status": "SHIPPED",
    "createdAt": "2024-05-23T16:59:30.363224"
}
```

### DELETE `/api/v1/orders/{order_id}`

- Description: Delete an order by id
- Headers:
```
  Authorization: Bearer token
```

- Response 200

```json
Order successfully deleted.
```