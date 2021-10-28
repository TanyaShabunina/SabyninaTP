# -*- coding: utf-8 -*-
s = input()
print(s[:s.find('h')] + s[s.rfind('h') + 1:])
