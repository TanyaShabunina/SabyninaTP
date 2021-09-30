# -*- coding: utf-8 -*-

print('Введите число x' )
x=int(input())
print('Введите число y' )
y=int(input())
print('Вы ввели х='+str(x)+' y='+ str(y))
x = x + y # 12
y = x - y # 12-7=5
x = x - y 
print('Поменяли значение: х='+str(x)+' y='+ str(y))