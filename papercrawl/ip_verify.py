import requests
import random
import time

http_ip = [
    '49.75.59.242:3128',
    '116.17.102.215:3128',
    # '114.238.151.103:9999',
    '59.37.18.243:3128',
    '111.56.101.65:3128',
    '183.213.26.12:3128',
    '49.89.67.7:9999'
]

if __name__ == "__main__":
    for i in http_ip:
        try:
            ip_proxy = i
            proxy_ip = {
                'http': ip_proxy,
                'https': ip_proxy,
            }
            print('使用代理的IP:', proxy_ip)
            response = requests.get("http://httpbin.org/ip", proxies=proxy_ip).text
            print(response)
            print('当前IP有效')
            time.sleep(2)
        except Exception as e:
            print(e.args[0])
            print('当前IP无效')
            continue
