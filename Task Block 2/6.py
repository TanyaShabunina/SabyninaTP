# -*- coding: utf-8 -*-

def table ():
   a = int(input('Введите первое число: '))
    b = int(input('Введите второе число: '))
    c = int(input('Введите третье число: '))
    d = int(input('Введите четвертое число: '))
    if (a + b + c + d) % 2 == 0:
        return "Да"
    else:
        return "Нет"
print(table())