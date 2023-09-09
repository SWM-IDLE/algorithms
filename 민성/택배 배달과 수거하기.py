def solution(cap, n, deliveries, pickups):
    answer = 0

    delivery_distance = n - 1
    pickup_distance = n - 1
    
    while delivery_distance != -1 or pickup_distance != -1:
        
        while delivery_distance >= 0 and deliveries[delivery_distance] == 0:
            delivery_distance -= 1
            
        while pickup_distance >= 0 and pickups[pickup_distance] == 0:
            pickup_distance -= 1
        
        
        dest = max(delivery_distance, pickup_distance)
        answer += ((dest+1) * 2)
            
        box_cnt = cap
        for i in range(delivery_distance, -1, -1):
            if box_cnt >= deliveries[i]:
                box_cnt -= deliveries[i]
                deliveries[i] = 0
            else:
                deliveries[i] -= box_cnt
                break
        
        box_cnt = cap
        for i in range(pickup_distance, -1, -1):
            if box_cnt >= pickups[i]:
                box_cnt -= pickups[i]
                pickups[i] = 0
            else:
                pickups[i] -= box_cnt
                break

    return answer
