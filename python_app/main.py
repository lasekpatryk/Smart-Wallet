from fastapi import FastAPI
import data_loader, json

app = FastAPI()

@app.get("/hist_price/{asset}/{period},{interval}")
def get_hist_price(asset, period, interval):
    df = data_loader.get_asset_price_history(asset, period, interval)
    df = df.reset_index()
    df = df.rename(columns={'Date': 'date', 'Open': 'open', 'High': 'high', 'Low': 'low', 'Close': 'close', 'Volume': 'volume'})
    df['date'] = df['date'].dt.strftime('%Y-%m-%d')
    res = df[['date', 'open', 'high', 'low', 'close', 'volume']].to_dict(orient='records')
    return res

@app.get("/currprice/{asset}")
def get_curr_price(asset):
    curr_price = data_loader.get_curr_price(asset)
    return curr_price

@app.get("/today_high_low/{asset}")
def get_today_high_low(asset):
    df = data_loader.get_today_high_low(asset)
    df = df.rename(columns={'High': 'high', 'Low': 'low'})
    res = df[['high', 'low']].to_dict(orient='records')
    return res

@app.get("/currencies")
def get_currencies():
    res = data_loader.get_currencies()
    json_res = [{"symbol": res[0][:res[0].index('=')], "price": round(res[1],2)} for res in res]
    return json_res

@app.get("/news/{asset}")
def get_asset_news(asset):
    df = data_loader.get_asset_news(asset)
    res = df.to_dict(orient='records')
    return res

@app.get("/calendar/{asset}")
def get_calendar(asset):
    df = data_loader.get_asset_calendar(asset)
    df = df.rename(columns={
        'Dividend Date': 'dividend_date',
        'Ex-Dividend Date': 'ex_dividend_date',
        'Earnings Date': 'earnings_date',
        'Earnings High': 'earnings_high',
        'Earnings Low': 'earnings_low',
        'Earnings Average': 'earnings_average',
        'Revenue High': 'revenue_high',
        'Revenue Low': 'revenue_low',
        'Revenue Average': 'revenue_average'
    })
    res = df.to_dict(orient='records')
    return res

@app.get("/targets/{asset}")
def get_target_price(asset):
    df = data_loader.get_analyst_price_targets(asset)
    return [df]

@app.get("/reccomendations/{asset}")
def get_recommendations(asset):
    df = data_loader.get_recommendations(asset)
    res = df.to_dict(orient='records')
    return res
