# -*- coding: utf-8 -*-
n = int (input("Введите натуральное число n: "))
f= 1
sum = 0
for i in range(1, n + 1):
    f *= i
    sum += f
print(sum)
