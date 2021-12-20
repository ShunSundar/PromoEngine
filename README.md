# PromoEngine

**Run Command :**

Run Application.java

**TestCase:**

**Test Setup :**

**Unit price for SKU IDs**
A      50
B      30
C      20
D      15

**Active Promotions :**

3 of A's for 130
2 of B's for 45
C & D for 30

**TestCase 1:**
1 * A     50
1 * B     30
1 * C     20
======
Total     100

**TestCase 2:**
5 * A     130 + 2*50
5 * B     45 + 45 + 30
1 * C     20
======
Total     370

**TestCase 3:**
3 * A     130
5 * B     45 + 45 + 1 * 30
1 * C     -
1 * D     30
======
Total     280