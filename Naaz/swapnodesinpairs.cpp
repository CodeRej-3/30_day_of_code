#include <bits/stdc++.h>

using namespace std;

void swap(int &a, int &b)
{
    int temp = a;
    a = b;
    b = temp;
}

struct ListNode
{
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution
{
public:
    ListNode *swapPairs(ListNode *head)
    {
        ListNode *temp = head;
        while (temp != NULL && temp->next != NULL)
        {
            swap(temp->val, temp->next->val);
            temp = temp->next->next;
        }
        return head;
    }
};

int main()
{
    Solution sl;
    ListNode *l = new ListNode(3);
    l->next = new ListNode(4);
    l->next->next = new ListNode(5);
    l->next->next->next = new ListNode(6);
    l->next->next->next->next = new ListNode(7);
    ListNode *r = sl.swapPairs(l);

    while (r)
    {
        cout << r->val << endl;
        r = r->next;
    }
}
