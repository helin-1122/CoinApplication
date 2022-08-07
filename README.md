# CoinApplication
CoinApplication provides operations on Coin and provides BPI infromation from coindesk(https://api.coindesk.com/v1/bpi/currentprice.json).
- Create/Update/Delete/Get by token/List API for Coin
- Get currentPrice API
- Get BPI(Bitcoin price index) API

Use In-memory H2 database.
- Coin Data is initialized every time when application resterts.

Coin APIs
- POST _/coins_           - create new coin
- PUT _/coins/{token}_    - update existing coin with token, e.g. token=USD or EUR
- GET _/coins_            - list all coins
- DELETE _/coins/{token}_ - delete coin by token
- GET _/coins/{token}_    - get coin by token 


Current price API
- GET _/currentPrice_     - get current price information from coindesk

BPI API
- GET _/bpis_             - list simplified BPI information(token, chinese name, rate)
