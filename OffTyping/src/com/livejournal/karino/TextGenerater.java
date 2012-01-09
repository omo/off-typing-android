package com.livejournal.karino;

import java.util.ArrayList;
import java.util.Random;

public class TextGenerater {
	ArrayList<String> texts;
	int currentIndex;
	int oneGameSize = 15;
	public TextGenerater()
	{
		initializeTexts();
		shuffle();
		
		currentIndex = 0;
	}
	private void initializeTexts() {
		texts = new ArrayList<String>();
		String[] arr = new String[]{
				"���܂̂Ƃ���","�Ă����Ƃ�","�́[�ǂ��[��","�ł������܂��B",
				"�����傤", "�͂��ׂ�", "�قƂ��̂�", "�Ȃ���", "������", "��������", "����",
				"���̂���́A", "������", "�����������Ȃ��Ă����B", "�ӂ�����ɂイ��傭", "�͂�Ԃ�����", "����΂���", "��񂵂イ���܂��B",
				"���������ł��", "��傤�Ăłӂ����", "����Ȃ�ɂ͂₢", "����ǂ낢�ǂ�", "������",
				"���傤����", "��������", "��������", "������", "��������", "�����Ԃ�","�����߂�","����",
				"�ȁ[��", "������", "�݂����܂�", "����Ȃ���",
				"�ׂ񂫂傤", "����̂�", "����Ȃ�", "���炢�킯�H"
				
		};
		for(String st : arr)
		{
			texts.add(st);
		}
	}
	private void shuffle() {
		int size = texts.size();
		Random rand = new Random();
		for(int i = 0; i < size; i++)
		{
			int nextInt = rand.nextInt(size);
			swap(i, nextInt);
		}
	}
	
	private void swap(int i, int j) {
		String tmp = texts.get(i);
		texts.set(i, texts.get(j));
		texts.set(j, tmp);
	}
	public String getCurrent()
	{
		return getAt(currentIndex);
	}
	
	public String getNext()
	{
		return getAt(currentIndex+1);
	}
	
	public String getAfterNext()
	{
		return getAt(currentIndex+2);
	}
	
	public String getAt(int i)
	{
		if(i < oneGameSize)
			return texts.get(i);
		return "";
	}
	
	public void reset()
	{
		shuffle();
		currentIndex = 0;
	}
	
	public int getTotalCharacterNum()
	{
		int sum = 0;
		for(int i = 0; i < oneGameSize; i++){
			String st = texts.get(i);
			sum += st.length();
		}
		return sum;
	}
	
	public void moveNext()
	{
		if(!isFinished())
			currentIndex++;
	}
	
	public boolean isFinished()
	{
		return currentIndex >= oneGameSize;
	}
}