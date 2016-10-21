class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        self.res = []
        self.group = {}
        self.change = []
        for str in strs:
            s = sorted(str)
            s = ''.join(s)
            self.change.append(s)

        for k,v in enumerate(self.change):
            if not self.group.has_key(v):
                self.group[v] = []
                self.group[v].append(k)
            else:
                self.group[v].append(k)

        for k,v in self.group.items():
            temp = []
            for index in v:
                temp.append(strs[index])
            self.res.append(temp)
        return self.res



if __name__ == '__main__':
    so = Solution()
    print so.groupAnagrams(["sd","ds"])
