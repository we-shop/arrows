.PHONY: prepl test test-clj test-cljs

prepl:
	clj -Adev \
		-J-Dclojure.server.jvm="{:port 5005 :accept clojure.core.server/io-prepl}" \
		-J-Dclojure.server.node="{:port 5006 :accept cljs.server.node/prepl}"

test: test-clj test-cljs

test-clj:
	clj -Adev -m cognitect.test-runner

test-cljs:
	clj -Adev -m cljs-test-runner.main
