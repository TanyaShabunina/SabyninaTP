# -*- coding: utf-8 -*-

def vyear():
    print("Введите год")
    year = int(input())
    if year % 4 == 0 and year % 100 != 0 or year % 400 == 0:
        return "Да"
    else:
        return "Нет"
print(vyear())