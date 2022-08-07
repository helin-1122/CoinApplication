# CoinApplication
CoinApplication provides operations on Coin and provides BPI infromation from coindesk(https://api.coindesk.com/v1/bpi/currentprice.json).
- Create/Update/Delete/Get by token/List API for Coin
- Get currentPrice API
- Get BPI(Bitcoin price index) API

Use In-memory H2 database.
- Coin Data is initialized every time when application resterts.

Coin APIs
- POST /coins           - create new coin
- PUT /coins/{token}    - update existing coin with token, e.g. token=USD or EUR
- GET /coins            - list all coins
- DELETE /coins/{token} - delete coin by token
- GET /coins/{token}    - get coin by token 


Current price API
- GET /currentPrice     - get current price information from coindesk

BPI API
- GET /bpis             - list simplified BPI information(token, chinese name, rate)
