# -*- coding: utf-8 -*-

n = int(input('Введите кол-во минут '))
h = n % (60 * 24) // 60
min = n % 60
print(h,min)