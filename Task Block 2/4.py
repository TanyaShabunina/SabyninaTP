# -*- coding: utf-8 -*-

def shnurki():
    a = int(input('Введите расстояние между рядами: '))
    b = int(input('Введите расстояние между отверстиями в ряду: '))
    l = int(input('Введите длину свободного конца шнурка: '))
    N = int(input('Введите количество отверстий: '))
    return (2 * N - 1) * a + 2 * l + 2 * (N - 1) * b
print(shnurki())