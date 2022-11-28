FAIL_MSG := "Тесты завершились успешно, а должы были упасть"

test:
	# Тестируем правильную реализацию
	@gradle clean test
	# Тестируем неправильную реализацию wrong1
	@! (IMPLEMENTATION=wrong1 gradle clean test) || (echo $(FAIL_MSG); exit 1)
	# Тестируем неправильную реализацию wrong2
	@! (IMPLEMENTATION=wrong2 gradle clean test) || (echo $(FAIL_MSG); exit 1)
	# Тестируем неправильную реализацию wrong3
	@! (IMPLEMENTATION=wrong3 gradle clean test) || (echo $(FAIL_MSG); exit 1)
