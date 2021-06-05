class Solution:
    def __init__(self):
        self.dp = dict()

    def minDistance(self, word1: str, word2: str) -> int:
        if len(word1) == 0 or len(word2) == 0:
            if (word1, word2) in self.dp:
                return self.dp[(word1, word2)]

            cost = max(len(word1), len(word2))
            self.dp[(word1, word2)] = cost
            return cost

        if word1[0] == word2[0] and (len(word1) == len(word2) == 1):
            if (word1, word2) in self.dp:
                return self.dp[(word1, word2)]

            cost = 0
            self.dp[(word1, word2)] = cost
            return cost

        if word1[0] != word2[0] and (len(word1) == len(word2) == 1):
            if (word1, word2) in self.dp:
                return self.dp[(word1, word2)]

            cost = 1
            self.dp[(word1, word2)] = cost
            return cost

        if word1[0] == word2[0]:
            if (word1, word2) in self.dp:
                return self.dp[(word1, word2)]

            cost = self.minDistance(word1[1:], word2[1:])
            self.dp[(word1, word2)] = cost
            return cost

        cost = 1 + min(self.minDistance(word1[1:], word2[1:]),
                       self.minDistance(word1, word2[1:]),
                       self.minDistance(word1[1:], word2))

        self.dp[(word1, word2)] = cost
        return cost


if __name__ == "__main__":
    sol = Solution()
    print(sol.minDistance(word1="horse", word2="ros"))
