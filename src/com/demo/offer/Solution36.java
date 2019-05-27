package com.demo.offer;

public class Solution36 {
	/**
	 * �������е��������֣����ǰ��һ�����ִ��ں�������֣����������������һ������ԡ�����һ������,�����������е�����Ե�����P

	 */
	
	public int getInvCount(int[] nums) {
		//ʹ�ñ����ⷨ������ÿ��Ԫ�أ����������ұ��ж��ٸ�Ԫ�ر���С
		int inv_count=0;
		for(int i=0;i<nums.length-1;i++) {
			for(int j=i+1;j<nums.length;j++) {
				if(nums[i]>nums[j]) {
					inv_count++;
				}
			}
		}
		return inv_count;
	}
	
	public int getInvCount1(int[] nums) {
		//ð������ԭ������Եĸ�������Ԫ�ؽ����Ĵ���
		int inv_count=0;
		for(int i=0;i<nums.length-1;i++) {
			for(int j=0;j<nums.length-i-1;j++) {
				if(nums[j]>nums[j+1]) {
					int temp=nums[j];
					nums[j]=nums[j+1];
					nums[j+1]=temp;
					inv_count++;
				}
			}
		}
		return inv_count;
	}
	
	public int getInvCount2(int[] nums) {
		//��������ԭ������Եĸ�������Ԫ������ƶ��Ĵ���
		int inv_count=0;
		for(int i=1;i<nums.length;i++) {
			if(nums[i]<nums[i-1]) {
				int temp=nums[i];
				int j=i-1;
				while(j >= 0 &&  nums[j]>temp) {
					//����
					nums[j+1]=nums[j];
					j--;
					inv_count++;
				}
				//��temp���ڿ�λ
				nums[j+1]=temp;
			}
		}
		return inv_count;
	}
	
	

	public int getInvCount3(int[] nums) {
		return 0;
		//�鲢����ԭ�����������=��벿�ֵ����������+�Ұ벿�ֵ����������+�ϲ����ֵ������������

	}
	
	public static int InversePairs(int [] array) {
        if(array==null||array.length==0)
        {
            return 0;
        }
        int[] copy = new int[array.length];
        for(int i=0;i<array.length;i++)
        {
            copy[i] = array[i];
        }
        int count = InversePairsCore(array,copy,0,array.length-1);//��ֵ��������
        return count;
             
    }
    private  static int InversePairsCore(int[] array,int[] copy,int low,int high)
    {
        if(low==high)
        {
            return 0;
        }
        int mid = (low+high)>>1;
        int leftCount = InversePairsCore(array,copy,low,mid)%1000000007;
        int rightCount = InversePairsCore(array,copy,mid+1,high)%1000000007;
        int count = 0;
        int i=mid;
        int j=high;
        int locCopy = high;
        while(i>=low&&j>mid)
        {
            if(array[i]>array[j])
            {
                count += j-mid;
                copy[locCopy--] = array[i--];
                if(count>=1000000007)//��ֵ��������
                {
                    count%=1000000007;
                }
            }
            else
            {
                copy[locCopy--] = array[j--];
            }
        }
        for(;i>=low;i--)
        {
            copy[locCopy--]=array[i];
        }
        for(;j>mid;j--)
        {
            copy[locCopy--]=array[j];
        }
        for(int s=low;s<=high;s++)
        {
            array[s] = copy[s];
        }
        return (leftCount+rightCount+count)%1000000007;
    }
}
