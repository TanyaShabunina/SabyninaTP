# -*- coding: utf-8 -*-

def chisla():
    print("Введите 3 целых числа")
    z = int(input())
    l = int(input())
    e = int(input())
    if z == l and z == e and l == e:
        return "3"
    else:
        pass
    if z == l or z == e or l == e:
        return "2"
    else:
        return "0"
print(chisla())