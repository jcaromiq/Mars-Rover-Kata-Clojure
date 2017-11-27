.PHONY: test
test:
	lein midje

.PHONY: autotest
autotest:
	lein midje :autotest