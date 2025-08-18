#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef char element;
typedef struct StackNode {
	element data;
	struct StackNode* link;
}StackNode;

typedef struct LinkedStackType {
	StackNode* top;
	int size;
}LinkedStackType;

void init_stack(LinkedStackType* s) {
	s->top = NULL;
	s->size = 0;
}

int is_empty(LinkedStackType* s) {
	return (s->top == NULL);
}

void push(LinkedStackType* s, element data) {
	StackNode* tmp = (StackNode*)malloc(sizeof(StackNode));
	tmp->data = data;

	tmp->link = s->top;
	s->top = tmp;
	s->size++;
}

element pop(LinkedStackType* s) {
	if (is_empty(s)) {
		return -1;
	}

	StackNode* top_node = s->top;
	element data = s->top->data;
	s->top = s->top->link;
	free(top_node);
	s->size--;
	return data;
}

void input_stack(LinkedStackType* s, char* str, int *no) {
	scanf("%s", str);
	int len = strlen(str);
	*no = 0;

	for (int i = 0; i < len; i++) {
		char c = str[i];

		switch (c) {
		case '(':
			push(s, c);
			break;
		case ')':
			if (is_empty(s))
				*no = 1;
			else
				c = pop(s);
			break;
		default:
			continue;
		}

	}
}

void print_check(LinkedStackType* s, int* no) {
	if (!is_empty(s) || *no != 0)
		printf("NO\n");
	else
		printf("YES\n");
}

int main() {
	LinkedStackType s;

	int no = 0;
	char str[102];

	int T;
	scanf("%d", &T);

	while (T--) {
		init_stack(&s);
		no = 0;

		input_stack(&s, str, &no);

		print_check(&s, &no);

	}
}