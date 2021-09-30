# -*- coding: utf-8 -*-

def figure ():
    f1 = int(input('Введите первое число '))
    f2 = int(input('Введите второе число '))
    f3 = int(input('Введите третье число '))
    if f1 < f2 and f1 < f3:
        return f1
    elif f2 < f1 and f2 < f3:
        return f2
    else:
        return f3
print(figure())