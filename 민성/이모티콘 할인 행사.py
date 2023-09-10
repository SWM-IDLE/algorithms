def solution(users, emoticons):
    answer = []
    
    sales = [10, 20, 30, 40]
    emoticon_sales = []
    emoticons_cnt = len(emoticons)
    
    def dfs():
        
        if len(emoticon_sales) == emoticons_cnt:
            register_cnt = 0
            total_purchase_money = 0
            
            for user in users:
                purchase_money = 0
                for i in range(emoticons_cnt):
                    if emoticon_sales[i] >= user[0]:
                        purchase_money += (emoticons[i] * ((100-emoticon_sales[i]) / 100))
                if purchase_money >= user[1]:
                    register_cnt += 1
                else:
                    total_purchase_money += purchase_money
            
            answer.append([register_cnt, total_purchase_money])
            return
        
        for i in range(4):
            emoticon_sales.append(sales[i])
            dfs()
            emoticon_sales.pop()
    
    dfs()
    answer.sort(key=lambda x: (-x[0], -x[1]))
    
    return answer[0]
