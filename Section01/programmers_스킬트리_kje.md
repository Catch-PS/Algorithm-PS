```python
Python 3.9.0 (v3.9.0:9cf6752276, Oct  5 2020, 11:29:23) 
[Clang 6.0 (clang-600.0.57)] on darwin
Type "help", "copyright", "credits" or "license()" for more information.

>> def solution(skill, skill_trees):
    skill = list(skill)
    cnt = 0
    for st in skill_trees:
        st = list(st)
        tmp = []
        for i in st:
            if i in skill:
                tmp.append(i)
        if len(tmp) == len(skill):
            if tmp == skill:
                cnt += 1
        else:
            for i in range(len(tmp)):
                if skill[i] != tmp[i]:
                    break
            else:
                cnt += 1
    return cnt
```
