# 서울대입구역 알고리즘 스터디 

# ⭐️ 1. 협업 도구 및 코드 공유 형식

### 과제 공유 방식

Slack + Github 노티 푸시 형식으로 진행후 코드리뷰 후 PR merge 진행 (단, 각자 푼 시간을 체크하여 기재)

### 파일 이름 규칙

leetcode_문제이름_이니셜, programmers_문제이름_이니셜, baekjoon_문제이름_이니셜

### 풀이 시간 기재

예: 1시간 이상 - 초과, 00분~60분 사이

### 스터디 2시간 진행 방식

1시간 30분 코드 리뷰 및 손코딩 대비, 30분 즉석 문제 풀이(추후 변경 가능)

(주차별 폴더에 보관할 것인지 미정 - 의견주세요!)

# 🔥 2. 알고리즘 문제

- **백준 1문제 , 프로그래머스 2문제 , leetcode 2문제**

5문제 + 알파

### 1.  백준 (직접 코테 광탈하면서 모은 문제들)

난이도 없는것들 영어문제 풀이 X, 플래티넘 난이도 X → 난이도가 높을 것으로 예상되므로 추후에 풀 예정

[https://www.acmicpc.net/workbook/view/4357](https://www.acmicpc.net/workbook/view/4357)

### 2. 프로그래머스(코딩테스트 기출 문제 위주로 진행 - kakao, summer/winter, 코드챌린지 등)

[https://programmers.co.kr/learn/challenges?tab=all_challenges](https://programmers.co.kr/learn/challenges?tab=all_challenges)

### 3. leetcode  Top 100 Liked Questions

[https://leetcode.com/problemset/top-100-liked-questions/](https://leetcode.com/problemset/top-100-liked-questions/)

PS 문제 풀이 개수 or 출석 벌금 규정(미정)

# 🐵 3. 스터디 시간

2020년 11월 4일 ~ 매주 수요일날 20:00 고정(일정 있을 시 합의하 수,목 유동적으로 변경가능 )

# 💻 4. Github PR 방식


### 요약
1. main, develop 브랜치로 나누어서 브랜치 진행
2. 알고리즘 풀이 후, develop 브랜치로 commit 및 push 진행 
2. push 이후 PR 요청 후 오른쪽 Reviewers 팀원 지정후 Request 요청
3. 스터디원 모두 코드 리뷰 완료되면 main 브랜치로 Merge

### PR Flow 

```Bash
git add (파일명 또는 전체(.))
git commit -m "커밋 메시지"
git push origin develop
정상적으로 push 진행 후 github에서 코드 리뷰어 지정 및 Pull Request 요청
요청된 문제 코드 리뷰 진행
모든 팀원 코드 리뷰 완료시 main 브랜치로 Merge
```


# 📌 5. Commit 메시지 규칙

- `FIX` - 보통 올바르지 않은 동작을 고친 경우에 사용합니다.
- `ADD` - 코드나 테스트, 예제, 문서 등의 추가가 있을 때 사용합니다
- `REMOVE` - 코드의 삭제가 있을 때 사용
- `REFACTOR` - 전면 수정이 있을 때 사용합니다.
- `UPDATE` - 원래도 정상적으로 동작하고 있었지만, 수정, 추가, 보완을 한다는 개념입니다. 코드보다는 주로 문서나 리소스, 라이브러리등에 사용합니다
- `IMPROVE` - 향상이 있을 때 사용합니다. 호환성, 테스트 커버리지, 성능, 검증 기능, 접근성 등 다양한 것들이 목적
- `MAKE` - 주로 기존 동작의 변경을 명시합니다.
- `REVISE` - 문서의 개정이 있을 때 주로 사용합니다.
- `CORRECT` - 주로 문법의 오류나 타입의 변경, 이름 변경 등에 사용합니다.
- `MOVE` - 코드의 이동이 있을 때 사용합니다.
- `RENAME` - 이름 변경이 있을 때 사용합니다.
- `VERIFY` - 검증 코드를 넣을 때 주로 사용합니다.
- `SET` - 변수 값을 변경하는 등의 작은 수정에 주로 사용합니다.
