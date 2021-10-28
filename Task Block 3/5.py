# -*- coding: utf-8 -*-
n = int (input("Введите натуральное число n: "))
sum = 0
for i in range(1, n + 1):
    sum += i ** 3
print(sum)

