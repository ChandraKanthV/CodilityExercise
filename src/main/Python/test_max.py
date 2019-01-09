def test_max_slice(A):

    maxVal=1
    begin=0
    end=0
    arrLength = len(A)

    for i in range(arrLength):
        begin = i
        end = begin
        while( end+1 < arrLength ):
            if( A[end] * A[end+1] < 0 ):
                end += 1
            elif((end == 0) and (A[end] * A[end+1]) == 0):
                end += 1
            elif((A[end] == 0) and (A[end-1] * A[end+1] >= 0)):
                end += 1
            elif(A[end+1] == 0):
                end += 1
            elif((end+1 == arrLength-1) and (A[end] * A[end+1] == 0)):
                end += 1
            else:
                break

        if(maxVal < end-begin+1):
            maxVal = end-begin+1

    print 'MAX Alternating Slice', maxVal

if __name__ == "__main__":
    A = [2]
    slice = [5,4,-3,2,0,1,-1,0,2,-3,4,-5]
    test_max_slice(slice)