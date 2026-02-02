import yfinance as yf
import pandas as pd

pd.set_option('display.max_columns', None)
pd.set_option('display.width', None)



def get_asset_price_history(asset, period, interval):
    ticker = yf.Ticker(asset)
    return ticker.history(period=period, interval=interval)

def get_curr_price(asset):
    ticker = yf.Ticker(asset)
    curr_price = round(ticker.fast_info['last_price'], 2)
    return curr_price

def get_today_high_low(asset):
    ticker = yf.Ticker(asset)
    return ticker.history(period='1d')

def get_currencies():
    forex_majors = [
        "EURUSD=X",  # Euro / Dolar amerykański
        "USDJPY=X",  # Dolar amerykański / Jen japoński
        "GBPUSD=X",  # Funt brytyjski / Dolar amerykański
        "USDCHF=X",  # Dolar amerykański / Frank szwajcarski
        "AUDUSD=X",  # Dolar australijski / Dolar amerykański
        "USDCAD=X",  # Dolar amerykański / Dolar kanadyjski
        "NZDUSD=X"  # Dolar nowozelandzki / Dolar amerykański
    ]
    res = []
    for i, currency in enumerate(forex_majors):
        ticker = yf.Ticker(currency)
        df = ticker.get_fast_info()
        res.append([forex_majors[i], df['lastPrice']])

    return res

def get_asset_news(asset):
    ticker = yf.Ticker(asset)
    news_data = []

    for item in ticker.get_news():

        content = item.get('content')

        title = content.get('title')
        summary = content.get('summary')
        pubDate = content.get('pubDate')
        url = content.get('clickThroughUrl').get('url')
        news_data.append({'title': title,'summary':  summary,'date':  pubDate,'url':  url})

    res = pd.DataFrame(news_data)
    res = res.sort_values(by="date", ascending=False).reset_index(drop=True)
    return res


def get_asset_calendar(asset):
    ticker = yf.Ticker(asset)
    calendar = ticker.get_calendar()
    res = pd.DataFrame(calendar)
    return res

def get_analyst_price_targets(asset):
    ticker = yf.Ticker(asset)
    target = ticker.get_analyst_price_targets()
    return target

def get_recommendations(asset):
    ticker = yf.Ticker(asset)
    return ticker.get_recommendations()

