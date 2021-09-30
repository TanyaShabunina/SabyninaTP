# -*- coding: utf-8 -*-

print('Введите возраст абитуриента')
age=int(input())
print('Введите имя абитуриента')
name=str(input())
print(name+'в возрасте'+ str(age) + 'лет')
if age >= 16:
	print('Поздравляем вы поступили в ВГУИТ')
elif(age<16 and age>0):
	print('Сначала нужно окончить школу!')
	if name!='Иван': 
		print('Вас не зовут Иван')
		print('Вам осталось учиться в школе'+ str(16-age) + 'лет')
else:
	print('Вас не зовут Иван11111')