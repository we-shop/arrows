.PHONY: prepl

prepl:
	clj -J-Dclojure.server.jvm="{:port 5005 :accept clojure.core.server/io-prepl}"
