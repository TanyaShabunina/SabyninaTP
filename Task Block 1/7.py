# -*- coding: utf-8 -*-

print('Введите число number' )
number=int(input())
number_temp= number % 2
if number_temp > 0:
	print('Число number не четное')
else:
    print('Число number  четное')