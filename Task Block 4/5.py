# -*- coding: utf-8 -*-
s = input()
f = (s).count('f')
if f == 1 :
	print(s.find('f'))
elif (f >= 2):
	a = s.find('f')
	q = s.rfind('f')
	print(a,q)
else:
		print("")
