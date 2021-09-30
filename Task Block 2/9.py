# -*- coding: utf-8 -*-

def chocolate():
    print("Введите размер элементов")
    n = int(input())
    m = int(input())
    k = int(input())
    if n * m > k and (k % m == 0 or k % n == 0):
        return "Да"
    else:
        return "Нет"
print(chocolate())