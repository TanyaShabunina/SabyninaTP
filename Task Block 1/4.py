# -*- coding: utf-8 -*-

seconds=int(1485714600)
d=datetime.datetime.fromtimestamp(seconds)
print(d.strftime('%d %H:%M:%S'))
