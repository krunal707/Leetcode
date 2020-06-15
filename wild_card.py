def scan(string, ptr):
    
    num = int(string[ptr])
    ptr+=1
    
    while ptr < len(string) and string[ptr].isdigit():
        num *= 10
        num += int(string[ptr])
        ptr += 1
    
    return [num, ptr]


def solution(S, T):
    is_digit_1 = False
    is_digit_2 = False

    digits_1, digits_2 = 0, 0

    ptr1, ptr2 = 0, 0

    while ptr1 <= len(S) and ptr2 <= len(T):


        if is_digit_1 or is_digit_2:

            if is_digit_1:
                digits_1 -= 1
                if digits_1 == 0:
                    is_digit_1 = False
            else:
                ptr1 += 1
                if ptr1 < len(S) and S[ptr1].isdigit():
                    res = scan(S,ptr1)
                    is_digit_1 = True
                    digits_1 = res[0]
                    ptr1 = res[1]

            if is_digit_2:
                digits_2 -= 1
                if digits_2 == 0:
                    is_digit_2 = False
            else:
                ptr2 += 1
                if ptr2 < len(T) and T[ptr2].isdigit():
                    res = scan(T,ptr2)
                    is_digit_2 = True
                    digits_2 = res[0]
                    ptr2 = res[1]
                    is_digit = True


            continue

        if ptr1 >= len(S) or ptr2 >= len(T):
            break

        is_digit = False
        if S[ptr1].isdigit():
            res = scan(S,ptr1)
            is_digit_1 = True
            digits_1 = res[0]
            ptr1 = res[1]
            is_digit = True

        if T[ptr2].isdigit():
            res = scan(T,ptr2)
            is_digit_2 = True
            digits_2 = res[0]
            ptr2 = res[1]
            is_digit = True

        if is_digit:
            continue

        if S[ptr1] != T[ptr2]:
            return False

        ptr1 += 1
        ptr2 += 1


    return True if not is_digit_1 and not is_digit_2 and ptr1 == len(S) and ptr2 == len(T) else False