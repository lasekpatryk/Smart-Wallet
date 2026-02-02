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
    results = []
    for i, currency in enumerate(forex_majors):
        ticker = yf.Ticker(currency)
        df = ticker.get_fast_info()
        results.append([forex_majors[i], df['lastPrice']])

    return results
#
# ticker = yf.Ticker("AAPL")
#
# # Pobierz historię (zamiast start/end możesz użyć period)
# # period: 1d, 5d, 1mo, 3mo, 6mo, 1y, 2y, 5y, 10y, ytd, max
# hist = ticker.history(period="1mo", interval="1d")
#
# # Wyświetl dane
# # print(hist.head())
#
# # Dodatkowe informacje (niektóre mogą zwracać pusty wynik zależnie od dostępności)
# print(ticker.get_recommendations())         # Podstawowe dane o firmie
#
# data = pd.DataFrame(ticker.history(period="1mo", interval="1d"))
# print(data)
#
# news_data = []
#
# for item in ticker.news:
#
#     content = item.get('content')
#
#     title = content.get('title')
#     summary = content.get('summary')
#     pubDate = content.get('pubDate')
#     url = content.get('clickThroughUrl').get('url')
#     news_data.append({'Tytuł': title,'Podsumowanie':  summary,'Data':  pubDate,'URL':  url})
#
# df_news = pd.DataFrame(news_data)
#
# print(df_news)
