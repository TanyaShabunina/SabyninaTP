# -*- coding: utf-8 -*-
print ("Введите числа так, что бы A ≤ B")
A = int (input ('Введите целое число A: '))
B = int (input ("Введите целое число B: "))
if A <= B:
	for i in range(A, B+1):
		print(i)
else:
	print("Возьмите числа другие удовлетворяющие условию A ≤ B")
