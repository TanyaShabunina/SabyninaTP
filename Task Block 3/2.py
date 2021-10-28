# -*- coding: utf-8 -*-
A = int (input ('Введите целое число A: '))
B = int (input ('Введите целое число B: '))
if A < B:
	for i in range(A, B+1):
		print(i)
else:
	for i in range(A, B-1, -1):
		print(i)
