# -*- coding: utf-8 -*-
s = input()
f = (s).count('f')
if f >= 2 :
	print(s.find('f', s.find('f') + 1))
elif (f == 1):
	print("-1")
else:
		print("-2")
