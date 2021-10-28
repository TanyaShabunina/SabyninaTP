# -*- coding: utf-8 -*-
A = int(input("Введите целое число A: "))
B = int(input("Введите целое число B: "))
for i in range(A - A % 2 -1, B -1, -2):
    print(i)
